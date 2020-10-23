package equipo.rocket.headhunterbackend.services.filters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import equipo.rocket.headhunterbackend.model.Idea;

public class CategoriaFilter implements FilterChain {

    private FilterChain nextFilter;

    @Override
    public void setNextFilter(FilterChain filter) {
        nextFilter = filter;

    }

    @Override
    public void filter(List<Idea> ideas, HashMap<String, Object> extraParams) {
        if (extraParams.containsKey("selectedCategories")) {
            ArrayList<String> categories = getSelectedCategories(extraParams);
            Iterator<Idea> it = ideas.iterator();
                    while (it.hasNext()) {
                        Idea idea = it.next();
                        if (!categories.contains(idea.getCategoria())) {
                            it.remove();
                        }
                    }

        }
        if (nextFilter != null) {
            nextFilter.filter(ideas, extraParams);
        }

    }

    private ArrayList<String> getSelectedCategories(HashMap<String, Object> extraParams) {
        ArrayList<String> selectedCategories = new ArrayList<String>();

        LinkedHashMap<String, Boolean> allCategories = ((LinkedHashMap<String, Boolean>) extraParams
                .get("selectedCategories"));
        allCategories.forEach((k, v) -> {
            if (v) {
                selectedCategories.add(k);
            }
        });
        return selectedCategories;
    }

}
