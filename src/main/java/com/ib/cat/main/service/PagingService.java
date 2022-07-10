package com.ib.cat.main.service;

import org.springframework.stereotype.Service;

@Service
public class PagingService {
	
	private static final int pageSize = 20;
	private final static int pageBlock = 10; //블럭 갯수는 10개
	
	private int curPage;
	private int blockStartNum = 0;
    private int blockLastNum = 0;
    private int lastPageNum = 0;
    private int total;
    
    public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
    public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getBlockStartNum() {
		return blockStartNum;
	}

	public void setBlockStartNum(int blockStartNum) {
		this.blockStartNum = blockStartNum;
	}

	public int getBlockLastNum() {
		return blockLastNum;
	}

	public void setBlockLastNum(int blockLastNum) {
		this.blockLastNum = blockLastNum;
	}

	public int getLastPageNum() {
		return lastPageNum;
	}

	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}

	public void startPaging(int pageNum, int total) {
		setCurPage(pageNum);
        makeLastPageNum(total);
        makeBlock(pageNum);
    }
	
	public void makeBlock(int curPage){
        int blockNum = 0;

        blockNum = (int)Math.floor((curPage-1)/ pageBlock);
        blockStartNum = (pageBlock * blockNum) + 1;
        
        blockLastNum = blockStartNum + (pageBlock-1);
        
        if(blockLastNum != 0 && lastPageNum !=0) {
	        if(blockLastNum / lastPageNum > 0)
	        	blockLastNum = lastPageNum;
        }
    }
	
	public void makeLastPageNum(int total) {
        if( total % pageSize == 0 ) {
            lastPageNum = (int)Math.floor(total/pageSize);
        }
        else {
            lastPageNum = (int)Math.floor(total/pageSize) + 1;
        }
    }
}
