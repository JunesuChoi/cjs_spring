package org.cjs.article;

import java.util.List;

/**
 * articleDao를 사용해서 글 목록, 조회, 추가, 수정, 삭제를 한다.
 * 
 * @author cjs
 */
public class ArticleService {

	ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * 글 목록
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * 글 조회
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * 글 등록
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("노래[탈모르파티] 산다는 게 다 그런 거지 누구나 민머리로 와");
		article.setContent("자신에게 실망하지 마 모든 게 많을 순 없어 오늘보다 덜 빠진 내일이면 돼 탈모는 죄가 아냐 (자라나라 머리머리 자라나라 자라나라 머리머리 자라나라 머리머리 자라나라 머리머리)");
		article.setUserId("1");
		article.setName("최준수");
		if (articleDao.addArticle(article) > 0)
			System.out.println("글을 추가했습니다.");
		else
			System.out.println("글을 추가하지 못했습니다.");
	}

	/**
	 * 글 수정
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("89");
		article.setTitle("충격! 삼성전자 이재용 회장!!");
		article.setContent("점심 식사를 먹었다고 전해져..");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("글을 수정했습니다.");
		else
			System.out.println("글을 수정하지 못했습니다.");
	}

	/**
	 * 글 삭제
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("1") > 0)
			System.out.println("글을 삭제했습니다.");
		else
			System.out.println("글을 삭제하지 못했습니다.");
	}
}
