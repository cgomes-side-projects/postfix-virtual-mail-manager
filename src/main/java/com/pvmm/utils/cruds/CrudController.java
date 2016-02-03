package com.pvmm.utils.cruds;

import com.pvmm.utils.Paginator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//TODO criar metodos para deletar
public abstract class CrudController<T extends CrudEntityInterface> implements CrudControllerInterface<T> {

    protected String viewsDir;
    protected Class<T> entityClass;

    @Autowired
    private HttpServletRequest request;

    public CrudController(String viewsDir, Class<T> entityClass) {
        this.viewsDir = viewsDir;
        this.entityClass = entityClass;
    }



    @RequestMapping()
    public String index(Model model,
                        Pageable pageable,
                        @RequestParam(name = "query", defaultValue = "") String query) {
        Page<T> records = searchOnRepository(query, pageable);

        model.addAttribute("records",  records);
        preparePaginator(records, model);

        return viewPath("search");
    }


    private void preparePaginator( Page<T> records, Model model ) {
        Paginator<T> paginator = new Paginator<>(records, request);

        model.addAttribute("paginator", paginator);
    }



    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("formModel", newEntity() );
        return viewPath("form");
    }


    @RequestMapping( value = "/create", method = RequestMethod.POST )
    public String createPost(@Valid @ModelAttribute("formModel") T formModel,
                             BindingResult errors,
                             RedirectAttributes redirectAttributes) {
        if( errors.getErrorCount() > 0 ) {
            return viewPath("form");
        }

        formModel = getRepository().save(formModel);

        redirectAttributes.addFlashAttribute("message", "Registro criado corretamente.");
        return "redirect:edit/" + formModel.getId();
    }


    @RequestMapping( value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model,
                       @PathVariable("id") T record,
                       final RedirectAttributes redirectAttributes) {

        if( record == null ) {
            return this.recordNotFound(redirectAttributes);
        }

        model.addAttribute("formModel", record);
        return viewPath("form");
    }


    @RequestMapping( value = "/edit/{id}", method = RequestMethod.POST)
    public String editPost(final @PathVariable("id") int id,
                           final @Valid @ModelAttribute("formData") T formData,
                           final BindingResult errors,
                           final RedirectAttributes redirectAttributes) {

        if( ! getRepository().exists(id) ) {
            return this.recordNotFound(redirectAttributes);
        }

        if( errors.getErrorCount() > 0 ) {
            return viewPath("form");
        }

        formData.setId( id );
        this.saveRecord(formData, redirectAttributes);
        return "redirect:" + formData.getId();

    }


    protected void saveRecord(T formData, RedirectAttributes redirectAttributes) {
        getRepository().save(formData);
        redirectAttributes.addFlashAttribute("message", "Registro salvo com sucesso.");
    }



    public String recordNotFound(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error_message", "Registro não encontrado.");
        return "redirect:../";
    }



    protected String viewPath( String viewName ) {
        return viewsDir + "/" + viewName;
    }


    protected T newEntity() {
        try {
            return entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


    ///////////////////////////////


    public String getViewsDir() {
        return viewsDir;
    }

    public void setViewsDir(String viewsDir) {
        this.viewsDir = viewsDir;
    }
}
