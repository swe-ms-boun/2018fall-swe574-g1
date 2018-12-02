package com.boun.swe.mnemosyne.annotation.annotationservice.service;

import com.boun.swe.mnemosyne.annotation.annotationservice.model.Annotation;
import com.boun.swe.mnemosyne.annotation.annotationservice.repository.AnnotationRepository;
import com.github.anno4j.Anno4j;
import com.github.anno4j.model.Body;
import com.github.anno4j.model.Target;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.config.RepositoryConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnotationService {
    private AnnotationRepository annotationRepository;
    public Anno4j anno4j = new Anno4j();

    @Autowired
    public AnnotationService(AnnotationRepository annRepo) throws RepositoryConfigException, RepositoryException {
        annotationRepository = annRepo;
    }

    public String createAnnotation(Body body, Target target)
            throws RepositoryException, IllegalAccessException, InstantiationException {
        com.github.anno4j.model.Annotation annotation = anno4j.createObject(com.github.anno4j.model.Annotation.class);
        annotation.addBody(body);
        annotation.addTarget(target);
        com.github.anno4j.model.Annotation save = annotationRepository.save(annotation);
        return save.getCreated();
    }

    public Annotation getAnnotation(String id) {
        return annotationRepository.findById(id).orElse(null);
        //POSSIBLE NULL-PTR EXCEPTION
    }
}
