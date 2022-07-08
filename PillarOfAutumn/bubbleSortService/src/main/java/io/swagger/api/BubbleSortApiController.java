package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.IntArray;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.BubbleSort;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

    public ResponseEntity<List<Integer>> bubbleSortPost(@Parameter(in = ParameterIn.DEFAULT, description = "bubblesort", required=true, schema=@Schema()) @Valid @RequestBody List<Integer> body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Integer> list = bubbleSort.sort(body);

            return new ResponseEntity<List<Integer>>(list,HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<List<Integer>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
