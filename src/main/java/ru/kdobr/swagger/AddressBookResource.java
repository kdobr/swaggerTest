package ru.kdobr.swagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")

public class AddressBookResource {

    Logger logger = LoggerFactory.getLogger(AddressBookResource.class);

    private ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Contacts by Id", notes = "Provide id and take Contact", response = Contact.class)
    public Contact getContact(@ApiParam(value = "ID for contact you wont to retrieve", required = true) @PathVariable String id) {
        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContact() {
        logger.trace("Home method");
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
         contacts.put(contact.getId(), contact);
         return contact;
    }
}
