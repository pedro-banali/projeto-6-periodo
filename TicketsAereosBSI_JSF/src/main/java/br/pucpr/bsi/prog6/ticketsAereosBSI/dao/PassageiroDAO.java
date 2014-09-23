package br.pucpr.bsi.prog6.ticketsAereosBSI.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.pucpr.bsi.prog6.ticketsAereosBSI.dao.util.HibernateUtil;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Funcionario;
import br.pucpr.bsi.prog6.ticketsAereosBSI.model.Passageiro;


public class PassageiroDAO extends PessoaDAO<Passageiro> {

	@Override
	public Long insert(Passageiro obj) {
		// TODO Auto-generated method stub
		return super.insert(obj);
	}
	@Override
	public boolean update(Passageiro obj) {
		// TODO Auto-generated method stub
		return super.update(obj);
	}
	@Override
	public boolean delete(Passageiro obj) {
		// TODO Auto-generated method stub
		return super.delete(obj);
	}
	@Override
	public List<Passageiro> findByFilter(Passageiro filter) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		try {
			
			Criteria c = session.createCriteria(Passageiro.class);
			c.createAlias("endereco", "endereco");
			if (StringUtils.isNotBlank(filter.getDocumento())) {
				c.add(Restrictions.like("documento", "%" + filter.getDocumento() + "%"));
			}
			if(StringUtils.isNotBlank(filter.getNumeroCartao()))
			{
				c.add(Restrictions.like("numeroCartao", "%" + filter.getNumeroCartao() + "%"));
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
			if(StringUtils.isNotBlank(filter.getUsuario()))
			{
				c.add(Restrictions.like("usuario", "%" + filter.getUsuario() + "%"));
			}
			return ((List<Passageiro>) c.list());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{ session.close(); }
	}
	private static final long serialVersionUID = 1L;
	
	private final static PassageiroDAO instance = new PassageiroDAO();
	
	private PassageiroDAO()
	{
		super(Passageiro.class);
	}
	public static PassageiroDAO getInstance() {
		return instance;
	}
}
