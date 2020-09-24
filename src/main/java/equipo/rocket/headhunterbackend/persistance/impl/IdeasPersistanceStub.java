package equipo.rocket.headhunterbackend.persistance.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.persistance.IdeasPersistance;

@Component("idp")
public class IdeasPersistanceStub implements IdeasPersistance {
    private ArrayList<Idea> ideas;

    public IdeasPersistanceStub() {
        ideas = new ArrayList<Idea>();
        Idea idea1 = new Idea("HeadHunter",
                "HeadHunter es una plataforma para emprendedores que buscan ayuda financiera y logística para llevar a cabo sus ideas a la realidad",
                new Date(), 10000, 1000, "Educacion", 5, "imagen");
        Idea idea2 = new Idea("MyDoctor", "Sistema para pedir consejos de médicos", new Date(), 1000000, 100000,
                "Salud", 3, "imagen");
        Idea idea3 = new Idea("BlueApron",
                "Our food system—the way in which food is grown and distributed—is complicated, and making good choices for your family can be difficult. We are changing that: By partnering with farmers to raise the highest-quality ingredients, by creating a distribution system that delivers ingredients at a better value and by investing in the things that matter most—our environment and our communities",
                new Date(), 2500000, 100000, "Gastronomia", 5, "imagen");
        Idea idea4 = new Idea("PokemonGo", "juego de AR", new Date(), 50000, 10000, "Cultura", 5, "imagen");
        Idea idea5 = new Idea("MyDoctor2", "Sistema para pedir consejos de médicos", new Date(), 1000000, 100000,
                "Salud", 5, "imagen");
                Idea idea6 = new Idea("HeadHunter",
                "HeadHunter es una plataforma para emprendedores que buscan ayuda financiera y logística para llevar a cabo sus ideas a la realidad",
                new Date(), 10000, 1000, "Educacion", 1, "imagen");

        ideas.add(idea1);
        ideas.add(idea2);
        ideas.add(idea3);
        ideas.add(idea4);
        ideas.add(idea5);
        ideas.add(idea6);
    }

    @Override
    public List<Idea> getAllIdeas() {
        return ideas;
    }

    @Override
    public Idea postIdea(Idea idea) {
        // TODO Auto-generated method stub
        return null;
    }

}
