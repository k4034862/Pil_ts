import React, { useState } from "react";
import "./Home.css";
import Calendar from "../../Component/Calendar/Calendar";
function HomeView(props: any) {
  const [eventData, setEventData] = useState([]);
  const [editEvent, setEditEvent] = useState(null); // 편집 중인 이벤트
  React.useEffect(() => {
    Init();
  }, []);
  const Init = async () => {
    // Dialog.ProgressBar(true);

    try {
    } catch (e) {
      //   setSnacks({
      //     toggle: true,
      //     type: "error",
      //     message: e.message,
      //   });
    } finally {
      //   Dialog.ProgressBar(false);
    }
  };

  return (
    <div style={{ width: "100%", height: "90vh" }}>
      <Calendar />
    </div>
  );
}

export default HomeView;
