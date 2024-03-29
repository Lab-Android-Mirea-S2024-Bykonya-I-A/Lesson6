package com.mirea.bykonyaia.employeedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mirea.bykonyaia.employeedb.dal.AppDatabase;
import com.mirea.bykonyaia.employeedb.dal.Employee;
import com.mirea.bykonyaia.employeedb.dal.EmployeeDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase database = App.getInstance().getDatabase();
        final EmployeeDao employeeDao = database.employeeDao();

        employeeDao.insert(new Employee(1,"qq", 2));
        employeeDao.insert(new Employee(2,"ww", 4));
        employeeDao.insert(new Employee(3,"ee", 6));

    }
}