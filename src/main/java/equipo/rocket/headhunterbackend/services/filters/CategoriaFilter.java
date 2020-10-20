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
        // cambiar para que reciba varias categorias -> categoria:[<categorias
        // seleccionadas>]
        if (extraParams.containsKey("selectedCategories")) {
            ArrayList<String> categories = new ArrayList<String>();

            LinkedHashMap<String, Boolean> selectedCategories = ((LinkedHashMap<String, Boolean>) extraParams
                    .get("selectedCategories"));
            selectedCategories.forEach((k, v) -> {
                if (v) {
                    categories.add(k);
                }
            });
            Iterator<Idea> it = ideas.iterator();
                    while (it.hasNext()) {
                        Idea idea = it.next();
                        if (!categories.contains(idea.getCategoria())) {//compare not in set of true values
                            it.remove();
                        }
                    }

        }
        if (nextFilter != null) {
            nextFilter.filter(ideas, extraParams);
        }

    }

}
