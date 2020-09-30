package equipo.rocket.headhunterbackend.services.filters;

import java.util.HashMap;
import java.util.List;

import equipo.rocket.headhunterbackend.model.Idea;

public interface FilterChain { //there's to much repeated code with this implementation, consider implementing chain with inheritance instead
    
    public void setNextFilter(FilterChain filter);

    public void filter(List<Idea> ideas,HashMap<String,Object> extraParams);
}
