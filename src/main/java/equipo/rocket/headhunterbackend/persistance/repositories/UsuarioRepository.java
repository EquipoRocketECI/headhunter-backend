package equipo.rocket.headhunterbackend.persistance.repositories;

import java.util.Set;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import equipo.rocket.headhunterbackend.model.Usuario;
import equipo.rocket.headhunterbackend.persistance.repositories.custom.UsuarioRepositoryCustom;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>, UsuarioRepositoryCustom{

}