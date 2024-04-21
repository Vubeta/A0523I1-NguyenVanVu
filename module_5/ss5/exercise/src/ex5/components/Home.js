import { useLocation } from "react-router-dom";

function Home() {
    const {state} = useLocation();

    return (
        <div>
            <h3>Account {state.username} login successfully!</h3>
        </div>
    );
}

export default Home;