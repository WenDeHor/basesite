package com.base.network.storage;

import com.base.network.model.Resume;

import java.util.Arrays;

public class SortedArreyStorage extends AbstractArreyStorage {


    @Override
    protected int getIndex(String uuid) {
        Resume searchkay = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchkay);
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1; //перевірка чи елемени є, і якщо є і їх більше "0" то здвигаєм масив копіюванням елементів
        if (numMoved < 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected void isertElement(Resume r, int index) {
        // вставка save  елемента в місце відповідно до відсотованого масиву
        int insertIdx = -index - 1;
        System.arraycopy(storage, insertIdx, storage, insertIdx + 1, size - insertIdx);
        storage[insertIdx] = r;
    }
}
