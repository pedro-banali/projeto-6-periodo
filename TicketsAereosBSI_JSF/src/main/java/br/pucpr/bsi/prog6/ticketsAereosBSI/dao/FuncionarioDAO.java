package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aeroporto;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Aviao;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Pessoa;

public class FuncionarioDAO extends PessoaDAO<Funcionario>{


	public List<Funcionario> findByFilter(Pessoa filter) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSession();
		try {
			
			Criteria c = session.createCriteria(Funcionario.class);
			if (StringUtils.isNotBlank(((Funcionario)filter).getCodigo())) {
				c.add(Restrictions.like("codigo", "%" + ((Funcionario)filter).getCodigo() + "%"));
			}
			if (StringUtils.isNotBlank(((Funcionario)filter).getContaCorrente())) {
				c.add(Restrictions.like("contaCorrente", "%" + ((Funcionario)filter).getContaCorrente() + "%"));
			}
			
			return ((List<Funcionario>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ session.close(); }
		
	}
	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	
	private final static FuncionarioDAO instance = new FuncionarioDAO();
	
	private FuncionarioDAO()
	{
		super(Funcionario.class);
	}
	public static FuncionarioDAO getInstance() {
		return instance;
	}
	
	@Override
	public java.util.List<Funcionario> findAll() {
		return super.findAll();
	};
	
	@Override
	public Funcionario findById(long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	
	@Override
	public List<Funcionario> findByFilter(Funcionario filter) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Criteria c = session.createCriteria(Funcionario.class);
			c.createAlias("endereco", "endereco");
			if (StringUtils.isNotBlank(filter.getCodigo())) {
				c.add(Restrictions.like("codigo", "%" + filter.getCodigo() + "%"));
			}
			if (StringUtils.isNotBlank(filter.getContaCorrente())) {
				c.add(Restrictions.like("contaCorrente", "%" + filter.getContaCorrente() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getEndereco().getRua()))
			{
				
				c.add(Restrictions.like("endereco.rua", "%" + filter.getEndereco().getRua() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getEndereco().getBairro()))
			{
				
				c.add(Restrictions.like("endereco.bairro", "%" + filter.getEndereco().getBairro() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getEndereco().getCidade()))
			{
				
				c.add(Restrictions.like("endereco.cidade", "%" + filter.getEndereco().getCidade() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getEndereco().getPais()))
			{
				
				c.add(Restrictions.like("endereco.pais", "%" + filter.getEndereco().getPais() + "%"));
			}
			if(filter.getEndereco().getNumero() > 0)
			{
				
				c.add(Restrictions.eq("endereco.numero", filter.getEndereco().getNumero()));
			}
			if(StringUtils.isNotBlank(filter.getEndereco().getComplemento()))
			{
				
				c.add(Restrictions.like("endereco.complemento", "%" + filter.getEndereco().getComplemento() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getEndereco().getEstado()))
			{
				
				c.add(Restrictions.like("endereco.estado", "%" + filter.getEndereco().getEstado() + "%"));
			}
			if(filter.getDataNascimento() != null)
			{

				c.add(Restrictions.eq("dataNascimento", filter.getDataNascimento()));
			}
			if(StringUtils.isNotBlank(filter.getTelefone()))
			{

				c.add(Restrictions.eq("telefone", filter.getTelefone()));
			}
			if(StringUtils.isNotBlank(filter.getNome()))
			{

				c.add(Restrictions.like("nome", "%" + filter.getNome() + "%" ));
			}
			if(StringUtils.isNotBlank(filter.getEmail()))
			{

				c.add(Restrictions.like("email", "%" + filter.getEmail() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getPapel().getNome()))
			{
				c.createAlias("papel", "papel");
				c.add(Restrictions.like("papel.nome", "%" + filter.getPapel().getNome() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getPapel().getCiaAerea().getNome()))
			{
				c.createAlias("papel.ciaAerea", "ciaAerea");
				c.add(Restrictions.like("ciaAerea.nome", "%" + filter.getPapel().getCiaAerea().getNome() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getUsuario()))
			{
				c.add(Restrictions.like("usuario", "%" + filter.getUsuario() + "%"));
			}
			return ((List<Funcionario>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ if(session != null) session.close(); }
	}
	
}
