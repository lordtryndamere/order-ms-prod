package com.liondevs.orders.ordersmsprod.constants;


import org.springframework.stereotype.Component;

@Component
public class  Constants {
	private final  Short  much = 's';


	//Delete lastIndex in a String
	private String buildNameEntity(String nameEntity){
		boolean endWithValidation = nameEntity.endsWith(Short.toString(much));
		boolean  isNotEmptyAndTheLastIndexIsS = nameEntity.length() > 0 && nameEntity.charAt(nameEntity.length() - 1) == 's';
		String buildMessageToSoMuch = nameEntity.substring(0, nameEntity.length() - 1);

		return isNotEmptyAndTheLastIndexIsS ? buildMessageToSoMuch : nameEntity;


	}

	public   String notFoundMessage(String nameEntity,String ... params){
		final String lastPartMessage = "not found";
		final String initialMessage = " with ";

		return nameEntity
				.concat(initialMessage)
				.concat(buildAndParameters(params))
				.concat(lastPartMessage);

	}

	private String buildAndParameters(String[] params){
		final String andMessage = " and ";
		return params.length == 2 ?
				params[0]
				.concat(": ")
				.concat(params[1])
				:
				params[0]
						.concat(": ")
						.concat(params[1])
						.concat(andMessage)
						.concat(params[2])
						.concat(": ")
						.concat(params[3]);
	}
}
