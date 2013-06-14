package com.rotiwen.entry;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.rotiwen.dao.AreaMapper;
import com.rotiwen.dao.DeskMapper;
import com.rotiwen.model.Area;
import com.rotiwen.model.Desk;
import com.rotiwen.util.Util;

public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSession session = Util.getSqlSessionFactory().openSession();
		// TODO Auto-generated method stub
		
//		Area area = new Area();
//		area.setId(UUID.randomUUID().toString());
//		area.setCode("SSYT_D");
//		area.setName("DÇø");
//		area.setCreateTime(new Date());
		
//		AreaMapper areaMapper = session.getMapper(AreaMapper.class);
//		
//		Area area = areaMapper.selectByPrimaryKey("59ff681c-f507-4a94-acd0-3935a6f5ee57");
//		
//		Desk desk = new Desk();
//		desk.setArea(area);
//		desk.setId(UUID.randomUUID().toString());
//		desk.setCode("C_05");
//		desk.setName("C_05");
//		
//		DeskMapper deskMapper = session.getMapper(DeskMapper.class);
//		deskMapper.insert(desk);
//		
//		session.commit();
//		session.close();
		
		DeskMapper deskMapper = session.getMapper(DeskMapper.class);
		
		Desk desk = deskMapper.selectByPrimaryKey("42094fd1-bdf6-4383-9292-8767ce4052c4");
		
		System.out.print(desk.toString());
		
		AreaMapper areaMapper = session.getMapper(AreaMapper.class);
		
		Area area = areaMapper.selectByPrimaryKey(desk.getArea().getId());
		
		List<Desk> desks = area.getDesks();
		
		System.out.println("desks.size:" + desks.size());
		
		for (Desk d: desks) {
			System.out.println(d.getId() + "\t" + d.getCode() + "\t" + d.getName());
		}
	}

}
