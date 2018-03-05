package br.com.solutis.cyberpunk.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.solutis.cyberpunk.model.Clone;
import br.com.solutis.cyberpunk.repository.filter.CloneFilter;
import br.com.solutis.cyberpunk.util.jpa.Transactional;

public class Clones implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Clone porId(Long id) {
		return manager.find(Clone.class, id);
	}

	public Clone guardar(Clone clone) {
		return manager.merge(clone);
	}

	@Transactional
	public void remover(Clone clone) {
		clone = porId(clone.getId());
		manager.remove(clone);
		manager.flush();
	}

	public Clone porNome(String nome) {
		Clone clone = null;
		try {
			clone = this.manager.createQuery("from Clone where lower(nome) = :nome", Clone.class)
					.setParameter("nome", nome.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			//nenhum clone encontrado
		}
		return clone;
	}

	@SuppressWarnings("unchecked")
	public List<Clone> filtrados(CloneFilter filtro) {

		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Clone.class);

		// MatchMode.ANYWHERE determina o like '%%'
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(),
					MatchMode.ANYWHERE));
		}

		return criteria.addOrder(Order.asc("nome")).list();
	}

}
