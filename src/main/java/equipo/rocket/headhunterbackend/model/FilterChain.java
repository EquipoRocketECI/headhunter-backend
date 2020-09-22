package equipo.rocket.headhunterbackend.model;

import java.util.HashMap;
import java.util.List;

public interface FilterChain {
    
    public void setNextFilter(FilterChain filter);

    public void filter(List<Idea> ideas,HashMap<String,Object> extraParams);
}
