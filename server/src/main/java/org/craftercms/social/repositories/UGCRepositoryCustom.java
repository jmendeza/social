/*
 * Copyright (C) 2007-2013 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.social.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.craftercms.social.domain.UGC;
import org.craftercms.social.util.action.ActionEnum;

public interface UGCRepositoryCustom {
	
	public List<UGC> findUGCs(String tenant, String target,
			String[] moderationStatusArr, ActionEnum action, 
			int page, int pageSize, String sortField, String sortOrder);

	List<UGC> findTenantAndTargetIdAndParentIsNull(String tenant,
			String target, ActionEnum action);
	
	UGC findUGC(ObjectId id, ActionEnum action, String[] moderationStatusArr);

	List<UGC> findByTenantTargetPaging(String tenant, String target,
			int page, int pageSize, ActionEnum action, String sortField, String sortOrder);

    List<String> findPossibleActionsForUGC(String ugcId, List<String> roles);

    List<UGC> findByParentIdWithReadPermission(ObjectId parentId, ActionEnum action, String[] moderationStatus, String sortField, String sortOrder);

	List<UGC> findByTenantAndSort(String tenant, ActionEnum action, String sortField, String sortOrder);

	List<UGC> findByModerationStatusAndTenantAndTargetId(
			String[] moderationStatus, String tenant, String targetId,
			boolean isOnlyRoot);

    List<UGC> findByTenantAndTargetIdRegex(String tenant, String targetIdRegex, int page, int pageSize,
                                           ActionEnum action, String sortField, String sortOrder);
}
