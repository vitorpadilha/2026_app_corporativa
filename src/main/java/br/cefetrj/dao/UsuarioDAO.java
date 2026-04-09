package br.cefetrj.dao;

import java.util.List;

import br.cefetrj.model.Usuario;
import br.cefetrj.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class UsuarioDAO extends GenericDAO<Usuario> {
    public List<Usuario> listarUsuariosAtivos() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            return entityManager.createQuery("from Usuario where ativo = true", Usuario.class).getResultList();
        }
    }

}
