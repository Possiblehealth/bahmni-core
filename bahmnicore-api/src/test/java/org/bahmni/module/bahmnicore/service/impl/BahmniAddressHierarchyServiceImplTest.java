package org.bahmni.module.bahmnicore.service.impl;

import org.bahmni.module.bahmnicore.dao.BahmniAddressHierarchyDao;
import org.bahmni.module.bahmnicore.model.BahmniAddressHierarchyEntry;
import org.bahmni.module.bahmnicore.service.BahmniAddressHierarchyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BahmniAddressHierarchyServiceImplTest {
    private BahmniAddressHierarchyService bahmniAddressHierarchyService;

    @Mock
    private BahmniAddressHierarchyDao bahmniAddressHierarchyDao;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        bahmniAddressHierarchyService = new BahmniAddressHierarchyServiceImpl(bahmniAddressHierarchyDao);
    }

    @Test
    public void shouldGetAddressHierarchyEntryByUuid() throws Exception {
        BahmniAddressHierarchyEntry addressHierarchyEntry = new BahmniAddressHierarchyEntry();
        addressHierarchyEntry.setName("test");
        when(bahmniAddressHierarchyDao.getAddressHierarchyEntryByUuid("uuid")).thenReturn(addressHierarchyEntry);

        BahmniAddressHierarchyEntry hierarchyEntryByUuid = bahmniAddressHierarchyService.getAddressHierarchyEntryByUuid("uuid");

        verify(bahmniAddressHierarchyDao, times(1)).getAddressHierarchyEntryByUuid("uuid");
        assertEquals(addressHierarchyEntry.getName(), hierarchyEntryByUuid.getName());
    }
}