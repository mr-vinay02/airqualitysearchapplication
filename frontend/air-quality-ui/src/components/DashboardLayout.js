import React from "react";
import Sidebar from "./SideBar";

function DashboardLayout({ children }) {
    return (
        <div className="dashboard-layout">
            <Sidebar />
            <div className="content-area">
                {children}
            </div>
        </div>
    );
}

export default DashboardLayout;
