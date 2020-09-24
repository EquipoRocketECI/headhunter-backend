package equipo.rocket.headhunterbackend.services.filters;

import java.util.HashMap;
import java.util.List;

import equipo.rocket.headhunterbackend.model.Idea;

public class CategoriaFilter implements FilterChain {

    private FilterChain nextFilter;

    @Override
    public void setNextFilter(FilterChain filter) {
        nextFilter=filter;

    }

    @Override
    public void filter(List<Idea> ideas, HashMap<String, Object> extraParams) {
        if(extraParams.get("Categoria")!=null){//revisar que el tipo del parametro si concuerde para usarlo abajo
            for (Idea idea : ideas) {
                if(idea.getCategoria().equals(extraParams.get("Categoria"))){
                    ideas.remove(idea);
                }
            }
        }
        if(nextFilter!=null){
            nextFilter.filter(ideas, extraParams);
        }

    }
    
}
