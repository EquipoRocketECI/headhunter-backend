package equipo.rocket.headhunterbackend.services.filters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import equipo.rocket.headhunterbackend.model.Idea;

public class CalificacionFilter implements FilterChain {

    private FilterChain nextFilter;

    @Override
    public void setNextFilter(FilterChain filter) {
        nextFilter=filter;
    }

    @Override
    public void filter(List<Idea> ideas, HashMap<String, Object> extraParams) {
        if(extraParams.containsKey("calificacion")){
            Iterator<Idea> it = ideas.iterator();
            while(it.hasNext()){
                Idea idea = it.next();
                if(idea.getCalificacion()!=Integer.parseInt(extraParams.get("calificacion").toString())){
                    it.remove();
                }
            }
        }
        if(nextFilter!=null){
            nextFilter.filter(ideas, extraParams);
        }
    }
    
}
