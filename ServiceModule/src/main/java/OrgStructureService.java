import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class OrgStructureService {

    public boolean addOrg() {
        throw new NotImplementedException();
    }

    public boolean deleteOrg(int id) {
        throw new NotImplementedException();
    }

    public OrgStructure findOrg(int id) {
        throw new NotImplementedException();
    }

    public OrgStructure findOrg(int id, String name) {
        throw new NotImplementedException();
    }

    public OrgStructure findOrg(String name) {
        throw new NotImplementedException();
    }

    public boolean changeOrgParent(int id, OrgStructure org) {
        throw new NotImplementedException();
    }

    public boolean changeOrgHead(int orgId, int userId) {
        throw new NotImplementedException();
    }

    public boolean addSubOrg(int orgId, int subOrgId) {
        throw new NotImplementedException();
    }

    public boolean changeOrgName(int id, String name) {
        throw new NotImplementedException();
    }

    public List<User> getStaff(int id) {
        throw new NotImplementedException();
    }

    public List<OrgStructure> getSubOrgs(int id) {
        throw new NotImplementedException();
    }
}
