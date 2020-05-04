package com.qa.ProgrammerNotFoundException;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The Programmer doesn't exist")

public class ProgrammerNotFoundException extends  EntityNotFoundException {
}
