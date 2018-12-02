package com.boun.swe.mnemosyne.annotation.annotationservice.controller;

import com.boun.swe.mnemosyne.annotation.annotationservice.model.Annotation;
import com.boun.swe.mnemosyne.annotation.annotationservice.service.AnnotationService;
import com.github.anno4j.Anno4j;
import com.github.anno4j.model.Body;
import com.github.anno4j.model.Agent;
import com.github.anno4j.model.Target;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openrdf.model.URI;
import org.openrdf.repository.RepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("annotations")
public class AnnotationController {

    private AnnotationService annotationService;
    private Anno4j anno4j;
    @Autowired
    public AnnotationController(AnnotationService annotationService) {
        this.annotationService = annotationService;
        this.anno4j = annotationService.anno4j;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String createAnnotation(@RequestBody String body, @RequestParam("target") String target)
            throws RepositoryException, IllegalAccessException, InstantiationException {

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonBody = (jsonParser.parse(body)).getAsJsonObject();
        JsonObject jsonTarget = (jsonParser.parse(target)).getAsJsonObject();

        Body annBody;
        Target annTarget;

        if(jsonBody.has("id"))
            annBody = anno4j.createObject(Body.class, (URI) jsonBody.get("id"));
        else{
            annBody = anno4j.createObject(Body.class);
            annBody.setResourceAsString(jsonBody.get("value").getAsString());
        }

        annTarget = anno4j.createObject(Target.class, (URI) jsonTarget.get("id"));

        return annotationService.createAnnotation(annBody, annTarget);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Annotation getAnnotation(@PathVariable("id") String id){
        return annotationService.getAnnotation(id);
    }
}
