package br.pucpr.bsi.prog6.ticketsAereosBSI.view.messages;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TicketsAereosBSIExceptionHandler extends ExceptionHandlerWrapper {
    private static final Logger log = Logger.getLogger(TicketsAereosBSIExceptionHandler.class.getCanonicalName());
    private ExceptionHandler wrapped;
 
    TicketsAereosBSIExceptionHandler(ExceptionHandler exception) {
        this.wrapped = exception;
    }
 
    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }
 
    @Override
    public void handle() throws FacesException {
 
        final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = i.next();
            ExceptionQueuedEventContext context =
                    (ExceptionQueuedEventContext) event.getSource();
 
            // get the exception from context
            Throwable t = context.getException();
 
            final FacesContext fc = FacesContext.getCurrentInstance();
            final Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
            final NavigationHandler nav = fc.getApplication().getNavigationHandler();
 
            //here you do what ever you want with exception
            try {
 
                //log error ?
                log.log(Level.ERROR, "Critical Exception!", t);
 
                //redirect error page
                requestMap.put("exceptionMessage", t.getMessage());
                
                //Caso seja uma excecao de TicketsAereos, permanecer na mesma pagina
                if(t.getMessage().contains("TicketsAereosBSIException")){
                	nav.handleNavigation(fc, null, null);	
                } else {
                	nav.handleNavigation(fc, null, "error");
                }
                
                fc.renderResponse();
 
                // remove the comment below if you want to report the error in a jsf error message
                String message = t.getMessage().substring(t.getMessage().lastIndexOf(":")+2);
                MessagesUtils.addError("erro", message);
 
            } finally {
                //remove it from queue
                i.remove();
            }
        }
        //parent hanle
        getWrapped().handle();
    }
}
