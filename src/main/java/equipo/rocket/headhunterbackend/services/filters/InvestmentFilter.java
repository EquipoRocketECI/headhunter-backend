package equipo.rocket.headhunterbackend.services.filters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import equipo.rocket.headhunterbackend.model.Idea;

import java.util.List;

public class InvestmentFilter implements FilterChain {

    private FilterChain nextFilter;

    @Override
    public void setNextFilter(FilterChain filter) {
        nextFilter=filter;

    }

    @Override
    public void filter(List<Idea> ideas, HashMap<String, Object> extraParams) {

        if(extraParams.containsKey("investmentRange")){
            Double lowBound=((LinkedHashMap<String,Number>) extraParams.get("investmentRange")).get("lowBound").doubleValue();
            Double highBound=((LinkedHashMap<String,Number>) extraParams.get("investmentRange")).get("highBound").doubleValue();//it would be great if I could map to InvestmentRange directly from spring, could not find an easy way.
            Iterator<Idea> it = ideas.iterator();
            while(it.hasNext()){
                Idea idea = it.next();
                if(lowBound>idea.getMontoLimite() || highBound<idea.getMontoLimite()){
                    it.remove();
                }
            }
        }
        if(nextFilter!=null){
            nextFilter.filter(ideas, extraParams);
        }
    }
    
}
