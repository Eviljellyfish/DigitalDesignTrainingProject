import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class OrgStructureController {

    private final OrgStructureService orgStructureService;

    public OrgStructureController(OrgStructureService orgStructureService) {
        this.orgStructureService = orgStructureService;
    }

    public OrgStructure add(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

    public boolean delete(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

    public OrgStructure getById(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

    public List<OrgStructure> getAllSubOrgs(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

    public List<User> getStaff(OrgStructure orgStructure) {
        throw new NotImplementedException();
    }

}
