package com.emarsys.rnwrapper;

import com.emarsys.predict.api.model.CartItem;
import com.emarsys.predict.api.model.Logic;
import com.emarsys.predict.api.model.RecommendationLogic;
import com.facebook.react.bridge.ReadableArray;

import java.util.List;
import java.util.ArrayList;

import static com.emarsys.predict.api.model.RecommendationLogic.ALSO_BOUGHT;
import static com.emarsys.predict.api.model.RecommendationLogic.CART;
import static com.emarsys.predict.api.model.RecommendationLogic.CATEGORY;
import static com.emarsys.predict.api.model.RecommendationLogic.POPULAR;
import static com.emarsys.predict.api.model.RecommendationLogic.RELATED;
import static com.emarsys.predict.api.model.RecommendationLogic.SEARCH;
import static com.emarsys.predict.api.model.RecommendationLogic.HOME;
import static com.emarsys.predict.api.model.RecommendationLogic.PERSONAL;

public class LogicParser {

	public static Logic parse(String logic) {
		Logic recommendedLogic;
		switch (logic) {
			case CART:
				recommendedLogic = RecommendationLogic.cart();
				break;
			case RELATED:
				recommendedLogic = RecommendationLogic.related();
				break;
			case CATEGORY:
				recommendedLogic = RecommendationLogic.category();
				break;
			case ALSO_BOUGHT:
				recommendedLogic = RecommendationLogic.alsoBought();
				break;
			case POPULAR:
				recommendedLogic = RecommendationLogic.popular();
				break;
			case HOME:
				List<String> variants = new ArrayList<String>();
				variants.add("1");
				variants.add("2");
				variants.add("3");
				variants.add("4");
				variants.add("5");
				variants.add("6");
				variants.add("7");
				variants.add("8");
				variants.add("9");
				recommendedLogic = RecommendationLogic.home(variants);
				break;
			case PERSONAL:
				recommendedLogic = RecommendationLogic.personal();
				break;
			default:
				recommendedLogic = RecommendationLogic.search();
		}
		return recommendedLogic;
	}

	public static Logic parse(String logic, ReadableArray array) {
		Logic recommendLogic;
		switch (logic) {
			case CART:
				List<CartItem> items = ArrayUtil.arrayToCartList(array);
				recommendLogic = RecommendationLogic.cart(items);
				break;
			default:
				recommendLogic = RecommendationLogic.search();
		}
		return recommendLogic;
	}

	public static Logic parse(String logic, String query) {
		Logic recommendedLogic;
		switch (logic) {
			case SEARCH:
				recommendedLogic = RecommendationLogic.search(query);
				break;
			case RELATED:
				recommendedLogic = RecommendationLogic.related(query);
				break;
			case CATEGORY:
				recommendedLogic = RecommendationLogic.category(query);
				break;
			case ALSO_BOUGHT:
				recommendedLogic = RecommendationLogic.alsoBought(query);
				break;
			case POPULAR:
				recommendedLogic = RecommendationLogic.popular(query);
				break;
			default:
				recommendedLogic = RecommendationLogic.search();
		}
		return recommendedLogic;
	}
}
