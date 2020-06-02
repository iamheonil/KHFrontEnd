package service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.face.FileService;

public class FileServiceImpl implements FileService {

	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {

		// Response Object Content-Type Setting
		resp.setContentType("text/html; charset=utf-8");
		
		// Response Object Write Stream
		PrintWriter out = null;
		
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 1. 파일 업로드 형태가 데이터가 맞는지 검사한다.
		//요청 메시지 Content-Type 이 multipart/form-data 가 맞는지 확인한다.
		boolean isMultipart = false;
		isMultipart = ServletFileUpload.isMultipartContent(req);
		
		// 1-1. multipart/form-data 인코딩으로 전송되지 않았을 경우 처리 중단하기
		if(!isMultipart) {
			out.append("<h1>enctype이 multipart/form-data 가 아닙니다.</h1>");
			out.append("<a href='/commons/fileupload'>업로드 페이지로 이동</a>");
			
			return;
		}
		
		// 1-2. 여기 이후부터는 multipart/form-data 로 요청된 상황
		// 파일이 전송되었음. 정상적인 흐름으로 처리
		
		System.out.println("TEST");
		
		// 2. 업로드된 파일을 처리하는 아이템팩토리 객체 생성
		// ItemFactory : 업로드된 데이터를 처리하는 방식을 설정하는 클래스
		//
		
		// FileItem : 클라이언트로부터 전송된 데이터를 객체화시킨 것
		
		// DiskFileItemFactory class
		// HDD 기반의 파일 아이템 처리 API
		// 업로드된 파일을 HDD 에 임시 저장하고 나중에 처리한다.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 3. 업로드 된 파일아이템의 용량이 적당히 작으면 메모리에서 처리하도록 설정
		
		int maxMem = 1 * 1024 * 1024; // 1MB
		factory.setSizeThreshold(maxMem);
		
		// 4. 용량이 적당히 크면 임시파일(HDD)을 만들어서 처리하도록 설정, 임시파일 폴더 설정
		ServletContext context = req.getServletContext();
		
		String path = context.getRealPath("");
		
		File repository = new File(path); // 임시 저장 폴더
		
		System.out.println("repository : " + repository);
		
		factory.setRepository(repository);
		
		
	}

}








