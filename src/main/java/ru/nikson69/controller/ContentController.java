package ru.nikson69.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.nikson69.model.Content;
import ru.nikson69.model.ContentSearchParametrs;
import ru.nikson69.model.ContentSearchResult;
import ru.nikson69.service.ContentService;
import ru.nikson69.service.UserProfileService;

import java.text.ParseException;


@Controller
@RequestMapping("/content")
@SessionAttributes("roles")

public class ContentController {


    @Autowired
    UserProfileService userProfileService;

    @Autowired
    ContentService contentService;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    static final Logger logger = LoggerFactory.getLogger(ContentController.class);

    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public ResponseEntity<ContentSearchResult> getContentList(@RequestParam(value ="count", required = false) Integer count,
                                                        @RequestParam(value ="page", required = false) Integer page,
                                                        @RequestParam(value ="name", required = false) String name,
                                                        @RequestParam(value ="description", required = false) String description,
                                                        @RequestParam(value ="category", required = false) String category,
                                                        @RequestParam(value ="createdBefore", required = false) String createdBefore,
                                                        @RequestParam(value ="createdAfter", required = false) String createdAfter
    ) {
        ContentSearchParametrs.Builder builder = new ContentSearchParametrs.Builder();
        ContentSearchParametrs parameters;
        try {
            parameters = builder.count(count)
                    .page(page)
                    .name(name)
                    .description(description)
                    .categories(category)
                    .createdBefore(createdBefore)
                    .createdAfter(createdAfter)
                    .build();
            ContentSearchResult result = contentService.findByParams(parameters);
            return ResponseEntity.ok(result);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<Content> getDetails(@PathVariable("id") Integer id) {
        Content content = contentService.findById(id);
        logger.info("Content : {}",content);
        if (content == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
        return ResponseEntity.ok(content);
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void createContent(@RequestBody Content content) {
        logger.info("New content : {}",content);
        if (content.getId() == null)
            contentService.saveContent(content);
        else
            contentService.updateContent(content);
     }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/item", method = RequestMethod.DELETE)
    public ResponseEntity<Content> deleteUser(@RequestBody Content content) {
        logger.info("Delete content : {}",content);
        contentService.deleteById(content.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}