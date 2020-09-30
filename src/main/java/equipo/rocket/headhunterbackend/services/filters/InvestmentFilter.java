package equipo.rocket.headhunterbackend.services.filters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import equipo.rocket.headhunterbackend.model.Idea;
import equipo.rocket.headhunterbackend.model.InvestmentRange;

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
            int lowBound=((LinkedHashMap<String,Integer>) extraParams.get("investmentRange")).get("lowBound");
            int highBound=((LinkedHashMap<String,Integer>) extraParams.get("investmentRange")).get("highBound");//it would be great if I could map to InvestmentRange directly from spring, could not find an easy way.
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
