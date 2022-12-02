package repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class AlunoRepositoryImpl implements Repository<Aluno>{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaEscolar");
	EntityManager manager = factory.createEntityManager();

	@Override
	public Aluno get(String id){
		Long idLong = Long.valueOf(id);
		Aluno aluno = manager.find(Aluno.class, idLong);
		return aluno;
	}

	@Override
	public List<Aluno> getAll(){
		Query query = manager.createQuery("SELECT a FROM Aluno a");
		List<Aluno> alunos = (List<Aluno>)query.getResultList();
		return alunos;
	}

	@Override
	public void insert(Aluno aluno){
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
	}

	@Override
	public void update(Aluno aluno) {
			manager.getTransaction().begin();
			manager.merge(aluno);
			manager.getTransaction().commit();
	}

	@Override
	public void delete(Aluno aluno) {
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
	}

	@Override
	public List<Aluno> getAllByFirstLetter(String letra) {
		Query query = manager.createQuery("SELECT a FROM Aluno as a WHERE a.nome LIKE :letra");
		query.setParameter("letra", letra + "%");
		List<Aluno> alunos = (List<Aluno>)query.getResultList();
		return alunos;
	}

}
