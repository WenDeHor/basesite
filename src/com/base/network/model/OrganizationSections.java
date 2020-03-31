package com.base.network.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSections extends Section {
    private static final long serialVersionUID = 1L;
    private  List<Organization> organizations;

    public OrganizationSections() {
    }

    public OrganizationSections(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public OrganizationSections(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "Organization in class Organization must not be null");
        this.organizations = organizations;
    }


    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSections that = (OrganizationSections) o;

        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        return organizations.toString();
    }
}
