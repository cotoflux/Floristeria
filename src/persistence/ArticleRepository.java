package persistence;

import java.util.ArrayList;
import java.util.List;

import domain.AbsArticle;

public class ArticleRepository {

	private static List<AbsArticle> articles;

	public ArticleRepository() {
		this.articles = new ArrayList<>();
	}

	public List<AbsArticle> getArticles() {
		return new ArrayList<>(articles);
	}

	public void addArticle(AbsArticle article) throws Exception {
		if (article == null)
			throw new Exception();
		articles.add(article);
	}

	public void deleteArticle(int position) {
		articles.remove(position);
	}

}
