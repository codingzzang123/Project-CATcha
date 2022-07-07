package com.ib.cat.media.service;

import org.springframework.stereotype.Controller;

@Controller
public class PagingUtil {
	
	/*
	 * 	전체 페이지 수 = ${total_Page} - contentsUtil에서 가져올 값
	 * 	@param rows //한 화면에 출력할 목록 수
	 * 	@param dataCount //총 데이터 수 => ${total_results} -contentsUtil에서 가져올 값
	 *  @return 전체 페이지 수 
	 */
//	public int pageCount(int rows, int dataCount) {
//		if (dataCount <= 0) {
//			return 0;
//		}
//		return dataCount/rows + (dataCount % rows > 0 ? 1 : 0);
//	}
//	
	public int totalPages (int totalPages) {
		
		return totalPages;
	}
	
	/*
	 * 	페이징 처리 GET 방식
	 * 	@param currentPage = 현재 페이지 번호 (i 로 받을거)
	 * 	@param totalPages  전체 페이지 수
	 * 	@param list_url 링크를 설정할 주소
	 * 	@return 페이징 처리 결과
	 * 
	 */
	
	public String paging(int currentPage, int totalPage, String listUrl) {
		StringBuilder sb = new StringBuilder();
		
		int numPerBlock = 10;
		int currentPageSetup;
		int n, page;
		
		if (currentPage < 1 || totalPage < 1) {
			return "";
		}
		
		if (listUrl.indexOf("?") != -1) {
			listUrl += "&";
		} else {
			listUrl += "?";
		}
		
		//currentPageSetup : 표시할 첫 페이지 -1
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
		if (currentPage % numPerBlock == 0 ) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		sb.append("<div class='paginate'>");
		
		//처음 페이지, 이전 (10페이지 전)
		n = currentPage - numPerBlock;
		if (totalPage > numPerBlock && currentPageSetup > 0) {
			sb.append("<a href='"+listUrl+"page=1&category=#####'>처음</a>");
			sb.append("<a href='"+listUrl+"page="+n+"&category=#####'>이전</a>");
		}
		
		//페이징 처리
		page = currentPageSetup + 1;
		while(page <= totalPage && page <= (currentPageSetup+numPerBlock)) {
			if(page == currentPage) {
				sb.append("<span>"+page+"</span>");
			} else {
				sb.append("<a href='"+listUrl+"page="+page+"&category=#####'>" + page + "</a>");
			}
			page++;
		}
		
		//다음(10페이지 후), 마지막 페이지
		n = currentPage + numPerBlock;
		if (n>totalPage) {
			n = totalPage;
		}
		if (totalPage - currentPageSetup > numPerBlock) {
			sb.append("<a href='"+listUrl+"page="+n+"&category=#####'>다음</a>");
			sb.append("<a href='"+listUrl+"page="+totalPage+"&category=#####'>끝</a>");
		}
		sb.append("</div>");
		
		return sb.toString();
	}

}
