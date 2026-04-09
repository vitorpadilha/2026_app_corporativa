package br.cefetrj.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.cefetrj.model.Usuario;
import br.cefetrj.utils.HibernateUtils;
import jakarta.persistence.EntityManager;

public class GenericDAO<T> {
    public void salvar(T entidade) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entidade); // antes: save()
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void atualizar(T entidade) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entidade); // antes: update()
        entityManager.getTransaction().commit();
    }

    public void deletar(int id) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        entityManager.getTransaction().begin();
        Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        T entidade = entityManager.find(entityClass, id);
        if (entidade != null) {
            entityManager.remove(entidade); // antes: delete()
        }
        entityManager.getTransaction().commit();
    }

    public T buscarPorId(int id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
            T usuario = entityManager.find(entityClass, id);
            return usuario;
        }
    }

    public List<T> listarTodos() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
            return entityManager.createQuery("from " + entityClass.getName(), entityClass).getResultList();
        }
    }

}
