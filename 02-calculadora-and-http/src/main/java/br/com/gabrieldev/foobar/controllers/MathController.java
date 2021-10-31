package br.com.gabrieldev.foobar.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldev.foobar.exception.UnsuportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberOne) ) {
			throw new UnsuportedMathOperationException("please set a value numeric");
		}
		Double sum = converteToDouble(numberOne) + converteToDouble(numberTwo);
		return sum;
	}
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a value numeric");
		}
		Double subtraction = converteToDouble(numberOne) - converteToDouble(numberTwo);
		return subtraction;
	}
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value= "numberTwo") String numberTwo) {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a value numeric");
			}
		Double multiplication = converteToDouble(numberOne) * converteToDouble(numberTwo);
		return multiplication;
	}
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value= "numberTwo") String numberTwo) {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a value numeric");
			}
		Double division = converteToDouble(numberOne) / converteToDouble(numberTwo);
		return division;
	}
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value= "numberTwo") String numberTwo) {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a value numeric");
			}
		Double division = (converteToDouble(numberOne) + converteToDouble(numberTwo)) /2;
		return division;
	}
	@RequestMapping(value = "/square-root/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "number") String number) {
		if(!isNumeric(number)) {
			throw new UnsuportedMathOperationException("please set a value numeric");
			}
		Double squareRoot = Math.sqrt(converteToDouble(number));
		return squareRoot;
	}
	
	private Double converteToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number  = strNumber.replaceAll(",", ".");	
		if(isNumeric(number)) return  Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number  = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
