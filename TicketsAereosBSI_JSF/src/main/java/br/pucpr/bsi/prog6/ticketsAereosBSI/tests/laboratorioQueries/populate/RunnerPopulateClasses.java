package br.pucpr.bsi.prog6.ticketsAereosBSI.tests.laboratorioQueries.populate;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class RunnerPopulateClasses {
	
	@Test
	public void runner(){
		JUnitCore junit = new JUnitCore();
		Result r = junit.run(TesteCiaAereaLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TesteAviaoLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TestePapelLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TesteFuncionarioLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TesteAeroportoLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TestePassageiroLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TesteRotaLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TesteHorarioLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TesteReservarComprarBilhetesLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
		
		r = junit.run(TesteCheckInLabPopulate.class);
		Assert.assertTrue(r.wasSuccessful());
	}
	
}
