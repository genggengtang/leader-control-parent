package org.zxs.leader.control.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.zxs.leader.control.dao.interf.IMeetingNoteMapper;
import org.zxs.leader.control.dao.interf.IPrjAttachmentMapper;
import org.zxs.leader.control.dao.model.MeetingNote;
import org.zxs.leader.control.dao.model.vo.output.MyMeetingNoteOut;
import org.zxs.leader.control.dao.model.vo.output.OptionsOut;
import org.zxs.leader.control.dao.model.vo.output.rows.MeetingNoteRow;
import org.zxs.leader.control.dao.model.vo.query.MeetingNoteQuery;
import org.zxs.leader.control.service.interf.IMeetingNoteService;
import org.zxs.leader.control.service.util.ExceptionMessageTranslator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class MeetingNoteServiceImpl implements IMeetingNoteService {

	private static final Log logger = LogFactory.getLog(MeetingNoteServiceImpl.class);
	
	private static final String TABLE_NAME_ENG = "meeting_note";
	
	@Resource
	private IMeetingNoteMapper meetingNoteMapper;
	
	@Resource
	private IPrjAttachmentMapper prjAttachmentMapper;

	@Override
	public PageInfo<MyMeetingNoteOut> getMeetingNoteByPage(int pageNum, int pageSize, MeetingNoteQuery query) {
		PageHelper.startPage(pageNum, pageSize);
        List<MyMeetingNoteOut> prgPageList = meetingNoteMapper.selectMyMeetingNote(query);
        return new PageInfo<>(prgPageList);
	}

	@Override
	public boolean isMeetingNoteExist(Integer id) {
		return meetingNoteMapper.selectByPrimaryKey(id) != null;
	}

	@Override
	public List<MeetingNote> getPrjAttachments(int prjId, int prjType) {
		return prjAttachmentMapper.selectByPrjAndType(prjId, prjType);
	}

	@Override
	public List<MyMeetingNoteOut> getPrjAttachments(int prjId, int prjType, int userId) {
		return prjAttachmentMapper.selectByPrjAndUser(prjId, prjType, userId);
	}

	@Override
	public PageInfo<MeetingNoteRow> getMeetingNoteOutsByPage(Integer pageNum, Integer pageSize, String keyword) {
		PageHelper.startPage(pageNum, pageSize);
		List<MeetingNoteRow> rows = null;
		if (null == keyword) {
			rows = this.meetingNoteMapper.selectAllOuts();
		} else {
			rows = this.meetingNoteMapper.selectRowsByKeyword(keyword);
		}
		return new PageInfo<>(rows);
	}

	@Override
	public List<OptionsOut> getAllMeetingNoteOptions() {
		return this.meetingNoteMapper.selectAllMeetingNoteOptions();
	}

	@Override
	public MeetingNote findById(Integer id) {
		return this.meetingNoteMapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(MeetingNote meetingNote) {
		return this.meetingNoteMapper.insert(meetingNote);
	}

	@Override
	public int update(MeetingNote meetingNote) {
		return this.meetingNoteMapper.updateByPrimaryKey(meetingNote);
	}

	@Override
	public String insertWithResult(MeetingNote record) {
		Integer id = record.getId();
		try {
			int change = this.meetingNoteMapper.insert(record);
			if (change > 0) {
				logger.info(String.format("新增成功！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
			} else {
				logger.info(String.format("新增失败！更改行数[%s] - 记录编号[%s] - 表[%s]。", change, id, TABLE_NAME_ENG));
			}
		} catch (DuplicateKeyException e) {
			String message = e.getRootCause().getMessage();
			String transMsg = ExceptionMessageTranslator.translate(message);
			String duplExcepMsg = String.format("新增失败！编号为[%s]在[%s]表中已经存在。%s。", id, TABLE_NAME_ENG, transMsg);
			logger.info(duplExcepMsg);
			return duplExcepMsg;
		} catch (DataIntegrityViolationException e) {
			String message = e.getRootCause().getMessage();
			String transMsg = ExceptionMessageTranslator.translate(message);
			String integrityExcepMsg = String.format("新增失败！编号为[%s]的记录在新增时违反数据完整性：%s，请检查该字段的数据类型！", id, transMsg);;
			logger.info(integrityExcepMsg);
			return integrityExcepMsg;
		}
		return null;
	}
	
}
