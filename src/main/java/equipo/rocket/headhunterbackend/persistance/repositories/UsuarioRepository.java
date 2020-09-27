package equipo.rocket.headhunterbackend.persistance.repositories;

import java.util.Set;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import equipo.rocket.headhunterbackend.persistance.custom.UsuarioRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import equipo.rocket.headhunterbackend.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>, UsuarioRepositoryCustom{

}