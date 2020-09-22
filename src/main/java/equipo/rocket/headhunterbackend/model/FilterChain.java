package equipo.rocket.headhunterbackend.model;

import java.util.HashMap;

public interface FilterChain {
    
    public void setNextFilter(FilterChain filter);

    public void filter(Idea[] ideas,HashMap<String,Object> extraParams);
}
