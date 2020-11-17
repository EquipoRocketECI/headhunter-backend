package equipo.rocket.headhunterbackend.persistance.repositories.custom;

import java.util.List;

import javax.transaction.Transactional;

import equipo.rocket.headhunterbackend.model.ExpertosRequeridos;
import equipo.rocket.headhunterbackend.model.Idea;

public interface IdeasRepositoryCustom {

	@Transactional
	public Idea postIdea(Idea idea);

	@Transactional
	public void putIdea(Idea idea);

	@Transactional
	public void addMonto(int idIdea, int newMontoRecolectado);

	@Transactional
	public void postExpert(ExpertosRequeridos exp);

	@Transactional
	public List<ExpertosRequeridos> getExpertsByIdea(int idIdea);

	@Transactional
	public List<Idea> getDestacadas();

	@Transactional
	public List<String> getCategorias();

	@Transactional
	public List<Idea> getIdeasByUser(String userEmail);

	@Transactional
	public List<Idea> getIdeasByFuzzyQuery(String query);

}
