package ecommerce.object_jars.utility;

import org.apache.commons.lang3.StringUtils;

public class StringUtility {

	public static boolean isNullOrEmpty(String input) {

		if (input == null || StringUtils.isBlank(input)) 
			return true;
		return false;
	}

}
