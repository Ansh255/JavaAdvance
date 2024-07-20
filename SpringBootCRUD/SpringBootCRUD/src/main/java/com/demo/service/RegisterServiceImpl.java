package com.demo.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.DTO.RegDTO;
import com.demo.DTO.Response;
import com.demo.dao.RegisterDAO;
import com.demo.model.LoginVO;
import com.demo.model.RegVO;
import com.demo.model.RegisterVO;
import com.demo.util.BaseMethods;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private BaseMethods baseMethods;

	@Override
	public void insert(RegisterVO registerVO) {
		this.registerDAO.insert(registerVO);
	}

	@Override
	public List<RegVO> search() {
		return this.registerDAO.search();
	}

	@Override
	public List<RegisterVO> findById(int id) {
		return this.registerDAO.findById(id);
	}

	public ResponseEntity saveUser(RegDTO regdto) {

		Response response = this.baseMethods.validateUserRequest(regdto);

		if (!response.isStatus()) {
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
		try {
			LoginVO loginVO = new LoginVO();
			loginVO.setStatus(true);
			loginVO.setPassWord(regdto.getPs());
			loginVO.setUserName(regdto.getUn());

			this.registerDAO.saveL(loginVO);

			RegVO regVO = new RegVO();
			regVO.setLoginvo(loginVO);
			regVO.setStatus(true);
			regVO.setFirstName(regdto.getFn());
			regVO.setLastName(regdto.getLn());
			this.registerDAO.saveR(regVO);

			regdto.setId(regVO.getId());
			response.setData(regdto);
			response.setStatus(true);
			response.setMassage("Data Inserted");

		} catch (Exception e) {
			response.setMassage(e.getMessage());
			response.setStatus(false);
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(response, HttpStatus.OK);

	}

	public ResponseEntity viewUser() {
		try {
			List<RegVO> registerList = this.search();

			return new ResponseEntity(registerList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public ResponseEntity delete(int id) {
		Response response = new Response();
		try {
			List<RegVO> regvolist = this.registerDAO.findByIdDelete(id);

			if (regvolist == null || regvolist.isEmpty()) {
				response.setMassage("Invalid Id");
				return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
			}
			RegVO regvo = regvolist.get(0);
			regvo.setStatus(false);
			this.registerDAO.saveR(regvo);

			LoginVO loginvo = regvo.getLoginvo();
			loginvo.setStatus(false);
			this.registerDAO.saveL(loginvo);

			response.setStatus(true);
			response.setMassage("Delete Succesfully");
		} catch (Exception e) {
			response.setMassage(e.getMessage());
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity update(RegDTO regdto, int id) {
		Response response = this.baseMethods.validateUserRequest(regdto);
		try{
			List<RegVO> regvolist = this.registerDAO.findByIdDelete(id);
			System.out.println(regvolist);
			if(regvolist == null || regvolist.isEmpty()){
				
				return this.saveUser(regdto);
			}
			RegVO regvo = regvolist.get(0);
			
			
			System.out.println(regdto.getFn());
			System.out.println(regdto.getId());
			System.out.println(regdto.getLn());
			System.out.println(regdto.getPs());
			System.out.println(regdto.getUn());
			System.out.println(regvo.getLoginvo().getId());
			
			LoginVO loginvo = regvo.getLoginvo();
			loginvo.setId(regvo.getLoginvo().getId());
			loginvo.setUserName(regdto.getUn());
			loginvo.setPassWord(regdto.getPs());
			this.registerDAO.saveL(loginvo);
			
			regvo.setFirstName(regdto.getFn());
			regvo.setLastName(regdto.getLn());
			this.registerDAO.saveR(regvo);
			
			
			
			regdto.setId(regvo.getId());
			response.setData(regdto);
			response.setStatus(true);
		}
		catch(Exception e){
			response.setMassage(e.getMessage());
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.setStatus(true);
		response.setMassage("Updated Successfully");
		return new ResponseEntity(response,HttpStatus.OK);
		
	}

	
}
