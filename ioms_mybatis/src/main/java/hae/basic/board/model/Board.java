package hae.basic.board.model;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 * <pre>
 * 게시판 관련 정보 vo
 * </pre>
 *
 * @authors sgyoon
 * @since 2020. 9. 3.
 * @see
 */
public class Board {

    /** 게시글 순서 */
    private Integer id;

    /** 분류 */
    private String category;

    /** 제목 */
    @NotEmpty(message="{errors.required}")
    @Length(min=1, max=50, message="{errors.range}")
    private String title;

    /** 내용 */
    @NotEmpty(message="{errors.required}")
    private String description;

    /** 게시자 */
    @NotEmpty(message="{errors.required}")
    private String regUser;

    /** 게시일 */
    private String regDate;

    /** 조회수 */
    private String viewCount;

	/** 검색조건 */
	private String searchCondition = "";

	/** 검색Keyword */
	private String searchKeyword = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getViewCount() {
		return viewCount;
	}

	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

}
