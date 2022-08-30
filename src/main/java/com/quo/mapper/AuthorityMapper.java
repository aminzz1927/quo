package com.quo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.quo.dto.AuthorityDto;
import com.quo.entity.Authority;
@Repository
public interface AuthorityMapper {
	
	@Select("select m.mname from menu m left join authority a on m.mid=a.mid where rid = #{rid}")
	public List<AuthorityDto> findListByRoleId(Integer rid);
}
