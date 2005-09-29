/**********************************************************************************
*
* $Id$
*
***********************************************************************************
*
* Copyright (c) 2005 The Regents of the University of California, The MIT Corporation
*
* Licensed under the Educational Community License Version 1.0 (the "License");
* By obtaining, using and/or copying this Original Work, you agree that you have read,
* understand, and will comply with the terms and conditions of the Educational Community License.
* You may obtain a copy of the License at:
*
*      http://cvs.sakaiproject.org/licenses/license_1_0.html
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
* INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
* AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
* DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*
**********************************************************************************/

package org.sakaiproject.tool.gradebook.facades.sections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.sakaiproject.api.section.facade.Role;

import org.sakaiproject.tool.gradebook.facades.Authz;


/**
 * An implementation of Gradebook-specific authorization needs based
 * on the shared Section Awareness API.
 */
public class AuthzSectionsImpl extends AbstractSectionsImpl implements Authz {
    private static final Log log = LogFactory.getLog(AuthzSectionsImpl.class);

	public boolean isUserAbleToGrade(String gradebookUid, String userUid) {
		return (getSectionAwareness().isSiteMemberInRole(gradebookUid, userUid, Role.INSTRUCTOR) || getSectionAwareness().isSiteMemberInRole(gradebookUid, userUid, Role.TA));
	}

	public boolean isUserAbleToGradeAll(String gradebookUid, String userUid) {
		return getSectionAwareness().isSiteMemberInRole(gradebookUid, userUid, Role.INSTRUCTOR);
	}

	public boolean isUserAbleToGradeSection(String sectionUid, String userUid) {
		return getSectionAwareness().isSectionMemberInRole(sectionUid, userUid, Role.TA);
	}

	public boolean isUserAbleToEdit(String gradebookUid, String userUid) {
		return getSectionAwareness().isSiteMemberInRole(gradebookUid, userUid, Role.INSTRUCTOR);
	}

	public boolean isUserGradable(String gradebookUid, String userUid) {
		return getSectionAwareness().isSiteMemberInRole(gradebookUid, userUid, Role.STUDENT);
	}

}



