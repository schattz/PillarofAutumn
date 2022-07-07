package io.swagger.api;

import io.swagger.model.IntArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.BubbleSort;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-22T03:05:56.290Z[GMT]")
@RestController
public class BubbleSortApiController implements BubbleSortApi {

    private static final Logger log = LoggerFactory.getLogger(BubbleSortApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    BubbleSort bubbleSort;

    @org.springframework.beans.factory.annotation.Autowired
    public BubbleSortApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<IntArray> bubbleSortPost(@Parameter(in = ParameterIn.DEFAULT, description = "bubblesort", required=true, schema=@Schema()) @Valid @RequestBody List<Integer> body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Integer> listResponseEntity = bubbleSort.sort(body);
            IntArray intArray = new IntArray();
            intArray = (IntArray) listResponseEntity;
            return new ResponseEntity<IntArray>(intArray,HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<IntArray>(HttpStatus.NOT_IMPLEMENTED);
    }

}
